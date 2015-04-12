This project aims to provide a fast, secure and easy-to-use password encryption based on salted hash algorithms compliant with JCE.

The generated encrypted password can be provided in hex or base64 encoding.

It also provides a password comparator to prevent comparison time attacks. The time the comparator takes to compare varies according to the length of the testing string, no matter the length of the actual password, thus making impossible for an attacker to determine the length of the password based on the comparison time.
