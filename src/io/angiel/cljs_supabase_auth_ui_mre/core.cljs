(ns io.angiel.cljs-supabase-auth-ui-mre.core
  (:require
    ["@supabase/auth-ui-react" :as sb-auth]
    ["@supabase/supabase-js" :as sb]
    [reagent.core :as r]
    [reagent.dom :as rdom]))

(defn run [ui]
      (rdom/render
        [ui]
        (js/document.getElementById "app")))

(def supabase (sb/createClient
                "http://127.0.0.1:54321"
                "could be even like that, you don't need to provide one
                just for creating client"))

(.log js/console supabase)

(run (fn [] [:f> [sb-auth/Auth {:supabaseClient supabase}]]))

;;(run (fn [] [:p "hello"]))