(ns game.core
  (:require ["phaser" :as phaser] 
            [game.scene-extend.core :as ext]
            [game.scene-extend.preload.core :as pre]
            [game.scene-extend.create.core :as c]))

(ext/add-preload-method! pre/load)
(ext/add-create-method! c/create)

(def y #js {:y 200})
(def arcade #js {:gravity y})
(def physics #js {:default "arcade" :arcade arcade})
(def config #js {:type 1 :width 800 :height 600 :physics physics
                   :scene ext/Extended-scene})

(new phaser/Game config)