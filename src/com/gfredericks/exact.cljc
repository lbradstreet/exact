(ns com.gfredericks.exact
  (:refer-clojure :exclude [+ - * /])
  (:require [clojure.core :as core]
            [com.gfredericks.exact.impl :as impl]))

(defn +
  ([] impl/additive-identity)
  ([x] x)
  ([x y] (impl/add x y))
  ([x y & zs] (reduce impl/add (impl/add x y) zs)))

(defn -
  ([x] (impl/negate x))
  ([x y] (impl/add x (impl/negate y)))
  ([x y & zs] (impl/add x (impl/negate (reduce impl/add y zs)))))
