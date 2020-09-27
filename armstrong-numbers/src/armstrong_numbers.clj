(ns armstrong-numbers)

(defn expt
  [base exponent]
  (reduce * (repeat exponent base)))

(defn sumOfPowers
  [numbers power]
  (reduce + 0 (map (fn [x](expt (bigint x) power)) numbers)))

(defn armstrong?
  [num]
  (let [digits (map #(Character/getNumericValue %) (str num))
        countDigits (count digits)]
    (= num (sumOfPowers digits countDigits))))
