(ns reverse-string
  (:require [clojure.string :as string]))

(defn reverse-string [s] ;; <- arglist goes here
  (apply str (into () s)))
