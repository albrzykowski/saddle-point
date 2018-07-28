(ns saddle-point.core-test
  (:require [clojure.test :refer :all]
            [saddle-point.core :refer :all]))

(deftest find-saddle-points-test
  (testing "If saddle points are returned when exist"
    (def matrix [[8 -8 -1 0] [4 2 1 3] [3 -1 0 2] [6 0 -2 10]])
    (is (= (find-saddle-points matrix) #{'(1 2)}))))

(deftest has-saddle-points-returns-true-test
  (testing "If true is returned when saddle points exist"
    (def matrix [[8 -8 -1 0] [4 2 1 3] [3 -1 0 2] [6 0 -2 10]])
    (is (= (has-saddle-points? matrix) true))))    

(deftest has-saddle-points-returns-false-test
  (testing "If false is returned when saddle points don't exist"
    (def matrix [[8 -8 -1 0] [4 2 -1 3] [3 -1 0 2] [6 0 -2 10]])
    (is (= (has-saddle-points? matrix) false))))    