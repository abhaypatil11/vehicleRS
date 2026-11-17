@GetMapping("/me")
public ResponseEntity<UserInfoResponse> getCurrentUser(
        org.springframework.security.core.Authentication authentication) {

    UserInfoResponse response = new UserInfoResponse(
            authentication.getName(),
            "Authenticated successfully"
    );

    return ResponseEntity.ok(response);
}
