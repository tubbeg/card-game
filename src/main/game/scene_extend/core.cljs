(ns game.scene-extend.core
  (:require ["phaser" :as phaser]))

(comment
  "ES5 extension of an ES6 class.
   
   This will ONLY work if you have:"
   
  :compiler-options {:output-feature-set :es5}

  "In your shadow-cljs.edn file.")

(defn Extended-scene []
  ; super
  (this-as this (.call phaser/Scene this) this))

(def Extended-scene-p (.-prototype Extended-scene))
(def phaser-scene-p (.-prototype phaser/Scene))

(set! Extended-scene-p (.create js/Object phaser-scene-p))
(set! (.-constructor Extended-scene-p) Extended-scene)

(defn add-preload-method! [member]
  (set! (.. Extended-scene -prototype -preload) member))
(defn add-update-method! [member]
  (set! (.. Extended-scene -prototype -update) member))
(defn add-create-method! [member]
  (set! (.. Extended-scene -prototype -create) member))