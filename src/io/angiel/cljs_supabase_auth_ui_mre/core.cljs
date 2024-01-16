(ns io.angiel.cljs-supabase-auth-ui-mre.core
  (:require
    ["@supabase/auth-ui-react" :as sb-auth]
    ["@supabase/supabase-js" :as sb]
    ["react-dom/client" :refer [createRoot]]
    [goog.dom :as gdom]
    [reagent.core :as r]))

(defonce root (createRoot (gdom/getElement "app")))

(defn run [ui]
  (.render root (r/as-element [ui])))

(def supabase (sb/createClient
                "http://127.0.0.1:54321"
                "could be even like that, you don't need to provide one
                just for creating client"))

(.log js/console supabase)

(defn- auth []
  [:> sb-auth/Auth {:supabaseClient supabase}])
(run auth)
