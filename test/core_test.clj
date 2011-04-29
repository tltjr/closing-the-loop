(ns core-test
  (:use [closing-the-loop.core] :reload)
  (:use lazytest.describe))

(describe "split"
  (it "splits on whitespace"
      (= '("1R" "1B") (split "1R 1B"))))

(describe "length-color"
  (it "returns vector with int and string"
      (= [14 "R"] (length-color "14R")))
  (it "parses black colors as well"
      (= [1 "B"] (length-color "1B"))))
      
(describe "line-to-segments"
  (it "returns a collection of vectors"
      (= '([1 "R"] [2 "R"] [1 "B"])
         (line-to-segments "1R 2R 1B"))))

(describe "split-by-color"
  (it "creates two collections"
      (= '[([1 "R"] [2 "R"]) ([1 "B"])]
         (split-by-color "1R 2R 1B"))))
