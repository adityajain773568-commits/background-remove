package in.aditya.pixelerase.service.impl;

import in.aditya.pixelerase.dto.UserDTO;
import in.aditya.pixelerase.entity.UserEntity;
import in.aditya.pixelerase.repository.UserRepository;
import in.aditya.pixelerase.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDTO saveUser(UserDTO userDTO) {
        Optional<UserEntity> optionalUser = userRepository.findByClerkId(userDTO.getClerkId());
        if (optionalUser.isPresent()) {
            UserEntity existingUser = optionalUser.get();
            existingUser.setClerkId(userDTO.getClerkId());
            existingUser.setFirstName(userDTO.getFirstName());
            existingUser.setLastName(userDTO.getLastName());
            existingUser.setPhotoUrl(userDTO.getPhotoUrl());
            existingUser.setEmail(userDTO.getEmail());
            if (userDTO.getCredits() != null) {
                existingUser.setCredits(userDTO.getCredits());
            }
             existingUser = userRepository.save(existingUser);
            return mapToDTO(existingUser);
        }
        UserEntity newUser = mapToEntity(userDTO);
        userRepository.save(newUser);
        return mapToDTO(newUser);
    }

    private UserEntity mapToEntity(UserDTO userDTO) {
        return UserEntity.builder()
                .clerkId(userDTO.getClerkId())
                .firstName(userDTO.getFirstName())
                .lastName(userDTO.getLastName())
                .photoUrl(userDTO.getPhotoUrl())
                .email(userDTO.getEmail())
                .build();

    }

    private UserDTO mapToDTO(UserEntity newUser) {

        return UserDTO.builder()
                .clerkId(newUser.getClerkId())
                .firstName(newUser.getFirstName())
                .lastName(newUser.getLastName())
                .photoUrl(newUser.getPhotoUrl())
                .email(newUser.getEmail())
                .credits(newUser.getCredits())
                .build();

    }
}
