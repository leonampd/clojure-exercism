(ns rna-transcription
    (:require [clojure.string :as str]))

(def rna-key-pair {:C "G"
                   :G "C"
                   :A "U"
                   :T "A"})

(get rna-key-pair (keyword "A"))

(defn- get-nucleotide
    [nucleotide]
    (let [rna-nucleotide (get rna-key-pair (keyword (str nucleotide)))]
        (if-not (nil? rna-nucleotide)
            rna-nucleotide
            (throw (AssertionError. "Wrong")))))

(defn to-rna
  [dna]
  (let [rna (map (fn
         [nucleotide]
         (get-nucleotide nucleotide)) dna)]
    (str/join "" rna)))
