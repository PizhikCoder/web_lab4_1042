package lab4.security.verifier;

@FunctionalInterface
public interface IVerifier<T> {
    boolean verify(T entity);
}
