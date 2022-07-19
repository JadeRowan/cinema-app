package cinema.controller;

import cinema.dto.request.UserRequestDto;
import cinema.dto.response.UserResponseDto;
import cinema.model.User;
import cinema.service.AuthenticationService;
import cinema.service.mapper.ResponseDtoMapper;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller responsible for new user registration
 */
@RestController
public class AuthenticationController {
    private final AuthenticationService authService;
    private final ResponseDtoMapper<UserResponseDto, User> userDtoResponseMapper;

    public AuthenticationController(AuthenticationService authService,
            ResponseDtoMapper<UserResponseDto, User> userDtoResponseMapper) {
        this.authService = authService;
        this.userDtoResponseMapper = userDtoResponseMapper;
    }

    /**
     * Register new user by calling register method on AuthService and returns DTO of created user
     *
     * @param requestDto object with user credentials for registration
     * @return           DTO of created user
     */
    @PostMapping("/register")
    public UserResponseDto register(@RequestBody @Valid UserRequestDto requestDto) {
        User user = authService.register(requestDto.getEmail(), requestDto.getPassword());
        return userDtoResponseMapper.mapToDto(user);
    }
}
