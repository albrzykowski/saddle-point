saddle-point
===========

[![Clojars Project](https://clojars.org/re.blacksqua/saddle-point/latest-version.svg)](https://clojars.org/re.blacksqua/saddle-point)

[![Build Status](https://travis-ci.com/albrzykowski/saddle-point.svg?branch=master)](https://travis-ci.com/albrzykowski/saddle-point)

Project is inspired by very interesting course by [prof. Marek Szopa](https://pl.wikipedia.org/wiki/Marek_Szopa) from [University of Silesia in Katowice](http://english.us.edu.pl/) about [Game Theory](https://en.wikipedia.org/wiki/Game_theory) and allows finding and asserting if saddle points exists in given payoff matrix. More about saddle points you cand find here (PL): https://www.youtube.com/watch?v=NjVSltkCA0E&t=3863s

## Main algorithm (to find saddle points) works as follow:

Let `A` be the payoff matrix.

1. Find minimal values in every row and return their indexes.
2. Transpose `A` and find maximal values in every row, return their indexes and reverse it.
3. Intersect sets from steps 1. and 2.


## Examples

Library contains two functions. 

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