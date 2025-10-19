#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.api.models;

public record Address(
        String street,
        String city,
        String state,
        String country,
        String postal_code
) {
}
