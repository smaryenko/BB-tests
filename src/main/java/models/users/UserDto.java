package models.users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.andreinc.mockneat.MockNeat;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    public String username;
    public String email;
    public String password;
    public String token;

    public static UserDto getRandomUser() {
        MockNeat mock = MockNeat.threadLocal();

        UserDto user = new UserDto();
        user.email = mock.emails().val();
        user.username = mock.users().val();
        user.password = mock.passwords().val();

        return user;
    }
}
