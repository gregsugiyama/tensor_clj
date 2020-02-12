(ns frontend.example-test
  (:require
   [cljs.test :refer-macros [deftest testing is]]))

(deftest example
  (testing "this should pass"
    (is (= 1 1))))
