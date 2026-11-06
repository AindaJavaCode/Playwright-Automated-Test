package org.example.model;

public record RegistrationData(

        String firstName,
        String lastName,
        String dob,
        String street,
        String houseNumber,
        String postalCode,
        String city,
        String state,
        String country,
        String phone,
        String email,
        String password) {

    /** Dummy user with a unique email so the test can run repeatedly. */
    public static RegistrationData dummy() {
        String uniqueEmail = "test" + System.currentTimeMillis() + "@test.com";
        return new RegistrationData(
                "Test",
                "Tester",
                "2001-01-01",
                "101 Testing Way",
                "42",
                "55555",
                "New York",
                "New York",
                "US",
                "5555555555",
                uniqueEmail,
                "Pass$w0rd1");
    }

    public String fullName() {
        return firstName + " " + lastName;
    }
}
