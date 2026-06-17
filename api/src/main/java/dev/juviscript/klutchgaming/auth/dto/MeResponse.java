package dev.juviscript.klutchgaming.auth.dto;

import dev.juviscript.klutchgaming.users.model.User;

public record MeResponse(Long id, String firstName, String lastName, String email, String role) {
    public static MeResponse from(User user) {
        return new MeResponse(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getRole().name());
    }
}
