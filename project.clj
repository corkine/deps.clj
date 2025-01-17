(defproject borkdude/deps.clj
  #=(clojure.string/trim
     #=(slurp "resources/DEPS_CLJ_VERSION"))
  :description "deps.clj: a Clojure port of the clojure bash script"
  :url "https://github.com/borkdude/deps.clj"
  :scm {:name "git"
        :url "https://github.com/borkdude/deps.clj"}
  :license {:name "Eclipse Public License 1.0"
            :url "http://opensource.org/licenses/eclipse-1.0.php"}
  :source-paths ["src"]
  :resource-paths ["resources"]
  :dependencies [[org.clojure/clojure "1.10.3"]]
  :profiles {:uberjar {:global-vars {*assert* false}
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"
                                  "-Dclojure.spec.skip-macros=true"]
                       :main borkdude.deps
                       :aot :all}
             :dev {:dependencies [[babashka/fs "0.1.11"]
                                  [babashka/process "0.0.2"]]}
             :native-image {}}
  :aliases {"deps.clj" ["run" "-m" "borkdude.deps"]}
  :deploy-repositories [["clojars" {:url "https://clojars.org/repo"
                                    :username :env/clojars_user
                                    :password :env/clojars_pass
                                    :sign-releases false}]])
