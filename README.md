# Brainfuck Interpreter

Reference implementation for the CUGB's Clojure workshop series.

## Run

```bash
lein run resources/hello.bf

lein run resources/cat.bf < resources/cat.bf
```

or

```bash
lein uberjar

java -jar target/brainfuck.jar ...
```

## Test

```bash
lein test
```

## License
MIT
