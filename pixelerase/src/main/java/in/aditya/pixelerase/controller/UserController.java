package in.aditya.pixelerase.controller;

import in.aditya.pixelerase.dto.UserDTO;
import in.aditya.pixelerase.response.RemoveBgResponse;
import in.aditya.pixelerase.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {


    private  final UserService userService;

    @PostMapping
    public RemoveBgResponse createOrUpdateUser(@RequestBody UserDTO userDTO){
        try{
            UserDTO user = userService.saveUser(userDTO);
             return RemoveBgResponse.builder()
                    .success(true)
                    .data(user)
                    .statusCode(HttpStatus.CREATED)
                    .build();
        } catch (Exception exception) {
            return RemoveBgResponse.builder()
                    .success(false)
                    .data(exception.getMessage())
                    .statusCode(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }


}
