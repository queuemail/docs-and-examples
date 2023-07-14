package queuemail.client.dto;

public class LoginResponseDTO
{

    private String token;
    private String role;
    private String userId;
    private String username;
    private String clientId;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }


    @Override
    public String toString() {
        return "LoginResponseDTO{" +
                "token='" + token + '\'' +
                ", role='" + role + '\'' +
                ", userId='" + userId + '\'' +
                ", username='" + username + '\'' +
                ", clientId='" + clientId + '\'' +
                '}';
    }
}
