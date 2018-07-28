# Saddle points of payoff matrix

Project is inspired by very interesting course by prof. Marek Szopa from University of Silesia in Katowice and allows finding and asserting if saddle points exists in given payoff matrix. More about saddle points you cand find here: https://www.youtube.com/watch?v=NjVSltkCA0E&t=3863s

## Examples

Library contains two function. 

First one `has-saddle-points?` allows you to assert if saddle points exists in given matrix:

    (deftest has-saddle-points-returns-true-test
        (testing "If true is returned when saddle points exist"
            (def matrix [[8 -8 -1 0] [4 2 1 3] [3 -1 0 2] [6 0 -2 10]])
            (is (= (has-saddle-points? matrix) true))))
            
The secont one `find-saddle-points` allows you to find saddle points in given matrix:

    (deftest find-saddle-points-test
        (testing "If saddle points are returned when exist"
            (def matrix [[8 -8 -1 0] [4 2 1 3] [3 -1 0 2] [6 0 -2 10]])
            (is (= (find-saddle-points matrix) #{'(1 2)}))))
