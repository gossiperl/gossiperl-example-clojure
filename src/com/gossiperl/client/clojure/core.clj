(ns com.gossiperl.client.clojure.core
  (:import [com.gossiperl.client OverlayWorker Supervisor]
           [com.gossiperl.client.config OverlayConfiguration]
           [com.gossiperl.client.listener GossiperlClientListener]
           [java.util ArrayList]))

(def overlay-config
  (let [config (OverlayConfiguration.)]
    (. config setClientName "clojure-client-test")
    (. config setClientPort 54321)
    (. config setClientSecret "clojure-client-secret")
    (. config setOverlayName "gossiperl_overlay_remote")
    (. config setOverlayPort 6666)
    (. config setSymmetricKey "v3JElaRswYgxOt4b")
    config))

(def subscriptions
  (let [data (ArrayList. ["member_in", "digestForwardableTest"])]
    data))

(def gossiperl-listener
  (proxy [GossiperlClientListener] []
    (connected [^OverlayWorker worker]
      (let [config (. worker getConfiguration)]
        (println (format "[%s] Connected." (. config getClientName)))))
    (disconnected [^OverlayWorker worker]
      (let [config (. worker getConfiguration)]
        (println (format "[%s] Disconnected." (. config getClientName)))))
    (subscribeAck [^OverlayWorker worker ^ArrayList events]
      (let [config (. worker getConfiguration)]
        (println (format "[%s] SubscribeAck received for events %s." (. config getClientName) events))))
    (unsubscribeAck [^OverlayWorker worker ^ArrayList events]
      (let [config (. worker getConfiguration)]
        (println (format "[%s] UnsubscribeAck received for events %s." (. config getClientName) events))))
    ))

(defn -main
  "Starts the Clojure sample client."
  []
  (let [supervisor (Supervisor.)]
    (let [configuration overlay-config]
      (let [overlay-name (. configuration getOverlayName)]
        (. supervisor connect configuration gossiperl-listener)
        (. Thread sleep 3000)
        (. supervisor subscribe overlay-name subscriptions)
        (. Thread sleep 3000)
        (. supervisor unsubscribe overlay-name subscriptions)
        (. Thread sleep 3000)
        (. supervisor disconnect overlay-name)
      ))))