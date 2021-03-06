package com.raf.user_service.controller;

import com.raf.user_service.dto.*;
import com.raf.user_service.security.CheckSecurity;
import com.raf.user_service.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /*@ApiOperation(value = "Get all users")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "What page number you want", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "size", value = "Number of items to return", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query",
                    value = "Sorting criteria in the format: property(,asc|desc). " +
                            "Default sort order is ascending. " +
                            "Multiple sort criteria are supported.")})
    @GetMapping
    @CheckSecurity(roles = {"ROLE_ADMIN", "ROLE_USER"})
    public ResponseEntity<Page<UserDto>> getAllUsers(@RequestHeader("Authorization") String authorization,
                                                     Pageable pageable) {
        return new ResponseEntity<>(userService.findAll(pageable), HttpStatus.OK);
    }*/

    @GetMapping("/{id}/discount")
    public ResponseEntity<DiscountDto> getDiscount(@PathVariable("id") Long id) {
        return new ResponseEntity<>(userService.findDiscount(id), HttpStatus.OK);
    }

    @ApiOperation(value = "Register user")
    @PostMapping
    public ResponseEntity<UserDto> saveUser(@RequestBody @Valid UserCreateDto userCreateDto) {
        return new ResponseEntity<>(userService.add(userCreateDto), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Login")
    @PostMapping("/login")
    public ResponseEntity<TokenResponseDto> loginUser(@RequestBody @Valid TokenRequestDto tokenRequestDto) {
        return new ResponseEntity<>(userService.login(tokenRequestDto), HttpStatus.OK);
    }

    @ApiOperation(value = "Add Credit Card")
    @PostMapping("/addCard")
    public ResponseEntity<CreditCardDto> addCreditCard(@RequestBody @Valid CreditCardCreateDto creditCardCreateDto) {
        return new ResponseEntity<>(userService.addCreditCard(creditCardCreateDto), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Change parameters")
    @PostMapping("/changeParameters")
    public ResponseEntity<UserDto> changeParameters(@RequestBody @Valid UserCreateDto userCreateDto) {
        return new ResponseEntity<>(userService.changeParameters(userCreateDto), HttpStatus.OK);
    }

}
