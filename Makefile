repl:
	clojure -A:dev:frontend:test --main "rebel-readline.main"

watch-test: node_modules
	bin/kaocha --watch

clean:
	rm -rf target/public
