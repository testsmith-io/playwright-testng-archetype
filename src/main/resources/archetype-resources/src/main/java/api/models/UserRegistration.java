#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.api.models;

public record UserRegistration(
        String first_name,
        String last_name,
        Address address,
        String phone,
        String dob,
        String password,
        String email
) {
}
