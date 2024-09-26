(ns game.scene-extend.preload.core)

(def url "https://labs.phaser.io")
(def sky "assets/skies/space3.png")
(def logo "assets/sprites/phaser3-logo.png")
(def red "assets/particles/red.png")

(defn load-set-baseurl! [this url]
  (.. this -load (setBaseURL url)))

(defn load-image! [this id path]
  (.. this -load (image id path)))

(defn _preload [this]
  (load-set-baseurl! this url)
  (load-image! this "sky" sky)
  (load-image! this "red" red)
  (load-image! this "logo" logo))

(defn load []
  (this-as this (_preload this)))