(def superheroes
  [
    {
      "first_name" "Potato",
      "last_name" "McFries",
      "superpowers" [
        {
          "name" "delicious", 
          "cost" 140,
          "power" 10
        }
        {
          "name" "sodium overdose", 
          "cost" 10,
          "power" 2
        }
      ]
      "vegan" true
    },

    {
      "first_name" "Octane",
      "last_name" "78",
      "superpowers" [
        {
          "name" "burn", 
          "cost" 3000,
          "power" 1000
        }
        {
          "name" "environmental_damage", 
          "cost" 12,
          "power" -10
        }
      ]
      "vegan" false
    },

    {
      "first_name" "Blue",
      "last_name" "Dabadee",
      "superpowers" [
        {
          "name" "earworm", 
          "cost" 80,
          "power" 2
        }
        {
          "name" "top charts", 
          "cost" 10000,
          "power" 12
        }
      ]
      "vegan" true
    }
  ]
)

(defn vegan-hero? [hero]
  (get hero "vegan"))

(defn get-powers [hero]
  (get hero "superpowers"))

(defn print-vegan-powers []
  (let [vegan-heroes (filter vegan-hero? superheroes)
        vegan-powers (mapcat get-powers vegan-heroes)]
    (println "All Vegan Powers: ")
    (doseq [power vegan-powers]
      (println power))))

(defn total-power-cost []
  (let [all-powers (mapcat get-powers superheroes)
        total-cost (reduce + (map #(get % "cost") all-powers))]
    (println "Total Power Cost:" total-cost)))

(defn -main []
  (print-vegan-powers)
  (total-power-cost))

(-main)