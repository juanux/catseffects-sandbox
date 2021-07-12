# Cats effects

## Functional programming basic concepts

### Functor

Is the abstractions of something that can be mapped to change its contents but not its context.

//TODO improve this deffinition

        ```
        def map[B](f: A => B): F[B]
        ```

We can use also **as** for this kind of situations where we want to ignore the value mapped and replace it for other:

        ```
        //This
        val replaced: F[String] = fa.map(_ => "replacement")
        // can be written as
        val replaced: F[String] = fa.as("replacement")
        ```

Or when we want to return Unit as replacement for the mapped value


        ```
        //This
        val voided: F[Unit] = fa.map(_ => ())
        // can be written as
        val voided: F[Unit] = fa.void
        ```

### Applicative (Applicative functor)

An applicative functor is a functor that can map multiple elements of the same context at the same time

//TODO improve this definition

        ```
        Option(1).map(_ + 1)                                   // Some(2)
        (Option(1), Option(2)).mapN(_ + _ + 1)                 // Some(4)
        (Option(1), Option(2), Option(3)).mapN(_ + _ + _ + 1)  // Some(7)
        ```

Using an applicative we can compose a tuple of *F* values into a single *F* using *manN*

        ```
        def map[B](A => B):          F[B]
        def mapN((A, B) => C):       F[C]
        def mapN[D]((A, B, C) => D): F[D]
        def mapN[Z]((A, ...) => Z):  F[Z]
        ```

in this way *mapN** transform *n* *Fs* into a one *F*. Given a n argument function *(A, ...) => Z*

***>* is used to compose two effetcs but discard the first one (only if both are success):

        ```
        //This
        val third: F[B] = (first, second).mapN((_, b) => b)
        //is the same as 
        val thrid: F[B] = first *> second
        ```

### Monad

Mechanism for sequencing computings. It provide a *flatMap*  method for F[A]

        ```
        def flatMap[B](f: A => F[B]): F[B]
         ```


## The effect pattern 

1. The type of the program should tell us what kind of effect the program will perform, in addition of the type of the value it will produce
2. If the behavior we are implementing depends on other external side effect, we separate describing the effects we want to happen from actually making it happen. Basically separate effect description from the execution.

Example: Option is an effect but Future is not an effect. Future is unsafe.













