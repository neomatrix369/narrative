package com.youdevise.test.narrative;

/**
 * Action declaration of what the Actor does to achieve the final desired result, which is then checked with a Then statement.
 * @param <T> The type of the tool the Actor uses
 */
public class When<TOOL, ACTOR extends Actor<TOOL>> {
    private final ACTOR actor;

    private When(ACTOR actor) {
        this.actor = actor;
    }

    public static <T, A extends Actor<T>> When<T, A> the(A actor) {
        return new When<T, A>(actor);
    }

    public <T, A extends Actor<T>> When<T, A> and_the(A actor) {
        return new When<T, A>(actor);
    }

    public When<TOOL, ACTOR> attempts_to(Action<ACTOR> action) {
        actor.perform(action);
        return this;
    }
}