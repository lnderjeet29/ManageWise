package com.inderjeet.ManageWise.business.filter

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseToken
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.HttpStatus
import org.springframework.web.filter.OncePerRequestFilter

class FirebaseAuthenticationFilter : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val token = request.getHeader("Authorization")?.removePrefix("Bearer ")
        if (token.isNullOrEmpty()) {
            response.sendError(HttpStatus.UNAUTHORIZED.value(), "Authorization header missing or invalid")
            return
        }
        try {
            val decodedToken: FirebaseToken = FirebaseAuth.getInstance().verifyIdToken(token)
            val userId = decodedToken.uid
            request.setAttribute("userHash", userId)
            filterChain.doFilter(request, response)
        } catch (e: Exception) {
            response.sendError(HttpStatus.UNAUTHORIZED.value(), "Invalid token")
        }
    }
}