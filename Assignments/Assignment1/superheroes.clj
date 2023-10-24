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

(defn print-superhero-info [superhero]
  (let [{:strs [first_name last_name superpowers]} superhero]
    (println (str "Superhero: " first_name " " last_name))
    (println "Superpowers:")
    (doseq [superpower superpowers]
      (println (str "- " (get superpower "name"))))))

(doseq [superhero superheroes]
  (print-superhero-info superhero)
  (println))
