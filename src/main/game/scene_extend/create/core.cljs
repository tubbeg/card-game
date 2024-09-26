(ns game.scene-extend.create.core)

(def scale #js {:start 1 :end 0})
(def particle-config #js {:speed 100 :scale scale :blendMode "ADD"})

(defn add-image [this a b id]
  (.. this -add (image a b id)))

; src/externs/externs.js handles this warning
(defn add-particles [this a b id config]
  (.. this -add (particles a b id config)))

(defn physics-add-image [this a b id]
  (.. this -physics -add (image a b id)))

(defn set-logo [logo]
  (doto logo
    (.setVelocity 100 200)
    (.setBounce 1 1)
    (.setCollideWorldBounds true)))

(defn particle-follow [particle follow]
  (.startFollow particle follow))

(defn _create [this]
  (add-image this 400 300 "sky")
  (let [p (add-particles this 0 0 "red" particle-config)
        l (-> (physics-add-image this 400 100 "logo")
              (set-logo))]
    (particle-follow p l)
    ))

(defn create []
  (this-as this (_create this)))