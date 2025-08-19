package org.crusadia.avramax.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.crusadia.avramax.dto.auth.RegisterUserRequest;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto extends RegisterUserRequest {

    List<OrderDto> orders = new ArrayList<>();
}


