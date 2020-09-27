(ns bob
  (:require [clojure.string :as string]))

(defn- question?
  [input]
  (string/ends-with? input "?"))

(defn- silence?
  [input]
  (string/blank? input))

(defn- yelling-me?
  [input]
  (and
    (not= (string/upper-case input)
         (string/lower-case input))
    (= (string/upper-case input) input)))

(defn- yelling-question?
  [input]
  (and (yelling-me? input) (question? input)))

(defn response-for
  [input]
  (let [trimedInput (string/trim input)]
    (cond
      (silence? trimedInput) "Fine. Be that way!"
      (yelling-question? trimedInput) "Calm down, I know what I'm doing!"
      (yelling-me? trimedInput) "Whoa, chill out!"
      (question? trimedInput) "Sure."
      :else "Whatever.")))
