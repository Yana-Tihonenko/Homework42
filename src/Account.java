import Exceptions.InvalidEmail;
import Exceptions.InvalidName;

import java.util.Objects;

public class Account {
    final static int MIN_LENGTH_EMAIL = 3;
    final static int MAX_LENGTH_EMIL = 30;
    final static int MIN_LENGTH_NAME = 10;
    final static int MAX_LENGTH_NAME = 25;
    private final String name;
    private final String email;
    private int reputation;

    public Account(String name, String email) {

        this.name = checkName(name);
        this.email = checkEmail(email);
        reputation = 0;
    }


    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    /**
     * Увеличивает репутацию.
     *
     * @param diff Разница между старым и новым значением, всегда положительная
     */
    public void increaseReputation(int diff) {
        if (diff > 0) {
            reputation += diff;
        }
    }

    /**
     * Уменьшает репутацию.
     *
     * @param diff Разница между старым и новым значением, всегда положительная
     */
    public void decreaseReputation(int diff) {
        if (diff > 0) {
            reputation -= diff;
        }
    }

    public int getReputation() {
        return reputation;
    }

    private static String checkName(String name) {
        if (name.length() < MIN_LENGTH_NAME) {
            throw new InvalidName(String.format("Error: name must be more than %d characters", MIN_LENGTH_NAME));
        }
        if (name.length() > MAX_LENGTH_NAME) {
            throw new InvalidName(String.format("Error: name must be less than %d characters", MIN_LENGTH_NAME));
        }
        return name;
    }

    private static String checkEmail(String email) {
        if (email.indexOf('@') == -1) {
            throw new InvalidEmail("Error: incorrect format e-mail");
        }
        if (email.length() < MIN_LENGTH_EMAIL) {
            throw new InvalidEmail(String.format("Error: email must be more than %d characters", MIN_LENGTH_EMAIL));
        }
        if (email.length() > MAX_LENGTH_EMIL) {
            throw new InvalidEmail(String.format("Error: email must be less than %d characters", MAX_LENGTH_EMIL));
        }
        return email;
    }


    @Override
    public String toString() {
        return String.format("name: %s, e-mail: %s, reputation: %s", name, email, reputation);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account account)) return false;
        return Objects.equals(name, account.name) && Objects.equals(email, account.email);
    }

    @Override
    public int hashCode() {
        return name.hashCode() * email.hashCode();
    }


}

