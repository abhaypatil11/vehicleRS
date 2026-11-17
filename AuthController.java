import com.rental.auth.dto.ForgotPasswordRequest;
import com.rental.auth.dto.ResetPasswordRequest;

@GetMapping("/me")
public ResponseEntity<UserInfoResponse> getCurrentUser(
        org.springframework.security.core.Authentication authentication) {

    UserInfoResponse response = new UserInfoResponse(
            authentication.getName(),
            "Authenticated successfully"
    );

    return ResponseEntity.ok(response);
}

@PostMapping("/forgot-password")
public ResponseEntity<ApiResponse> forgotPassword(
        @Valid @RequestBody ForgotPasswordRequest request) {

    authService.forgotPassword(request.getEmail());

    return ResponseEntity.ok(
            new ApiResponse("Password reset instructions generated")
    );
}


@PostMapping("/reset-password")
public ResponseEntity<ApiResponse> resetPassword(
        @Valid @RequestBody ResetPasswordRequest request) {

    authService.resetPassword(
            request.getToken(),
            request.getNewPassword()
    );

    return ResponseEntity.ok(
            new ApiResponse("Password reset successful")
    );
}
