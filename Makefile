repl: foreign-libs
	clojure -A:dev:frontend:test --main "rebel-readline.main"

watch-test: node_modules
	bin/kaocha --watch

clean:
	rm -rf target/public

# clojurescript

foreign-libs: target/public/js-out

target/public/js-out: node_modules src/frontend/foreign_libs/**
	npx webpack --config dev.webpack.js
	@touch $@

node_modules: package.json
	npm install
	@touch $@
