repl:
	clojure -A:dev:frontend:test --main "rebel-readline.main"

clean:
	rm -rf target/public
