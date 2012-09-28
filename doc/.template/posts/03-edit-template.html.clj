(h2 "Template file")
(p "Template files are compiled with [hiccup](https://github.com/weavejester/hiccup/).")


(h3 "Example")
#-CLJ
;; Define template options here
; @layout  default
; @title   misaki

;; define a custom clojure function
(defn header [s] [:header [:h1 s]])

;; passing the "site" variable for access to template options
(header (:title site))

(h2 "Posts")
(post-list)
;; or you can write posts list manually
;    [:ul
;     (for [p (:posts site)]
;       [:li (:title p)])]
CLJ

; /Example

(h3 "Template options")
(p "Template option format:")

#-CLJ
; @key value
CLJ

(h4 "Special options")
(ul
  [
   (p "`layout`: Specify layout file.")
   (p "`title`: Define template title.")
   (p "`format`: Specify template format (`\"html5\"`, `\"xhtml\"`, `\"html4\"`).
      No format template will be compiled by `hiccup.core/html`.")
   ]
  )

(h4 "Access template options")

(p "misaki provides a `site` variable with access to various template options. For example, you can access the template title with `(:title site)`.")


(h4 "Site updated date")

(p "`(:date site)` is site updated date (org.joda.time.DateTime).")

; /Template options

(h3 "Functions")

(p "You can define your own function in template or layout. However, the special misaki variables (e.g., `site` and `contents`) are not accessible in those functions.")

; /Functions

(h3 "Posts")

(p "`(:posts site)` contains a list of clojure hash-maps, one for each blog post.")


(h4 "Post data format")

(ul [(p "`:title`: Post title.")
     (p "`:url`: Post url.")
     (p "`:date`: Post date (org.joda.time.DateTime).")
     (p "`:file`: Post file (java.io.File).")
     (p "`:tag`: Tag list for this post.")
     (p "`:tag-name`: Joined tag names. This data is only contained by tag search.")
     (p "`:index`: Index filename string generated by `*url-base*` and `*index-name*`.")
     (p "`:prev`: Previous post data.")
     (p "`:next`: Next post data.")
     (p "`lazy-content`: Delayed post content. Use `force` to get post content.")])

(h4 "Tag list format")

(ul [
     (p "`:name`: Tag name.")
     (p "`:url`: Tag page URL.")
     ])

; /Posts

(h3 "Post tags")

(p "`(:tags site)` contains a list of hash-maps for a post's tags.")


(h4 "Tag data format")

(ul [
     (p "`:name`: Tag name.")
     (p "`:url`: Tag page URL.")
     (p "`:count`: Tag counts.")
     ])

; /Post tags

(h3 "Code Highlight")

(p "Code is highlighted using [google-code-prettify](http://code.google.com/p/google-code-prettify/).")

#-CLJ
#-CODE
(println "hello")
CODE

or

##CODE
(println "hello")
CODE
CLJ

(p "`CODE` can be replaced by any string.")
(p "If you define highlight setting, `CODE` string specifies a language.
   To define highlight setting, see [Highlight Setting](title: Highlight Setting).")

; /Code Highlight



(h2 "Layout file")
(h3 "Example")

(p "Layout options are the same as template options.")

#-CLJ
; @title  default title
; @format html5

[:head
 [:title (:title site)]]
[:body contents]
CLJ

(h4 "Special variables")

(ul [
     (p "`site`: Variable to access layout options.")
     (p "`contents`: Variable to handle template contents.")
     ])


(h4 "Layout in layout")

(p "Layout file can contain `:layout` option.")

[:ul
 [:li "default.clj"
#-CLJ
; @title  default title
; @format html5
[:head [:title (:title site)]]
[:body contents]
CLJ
  ]
 [:li "post.clj"
#-CLJ
; @layout default
; @title  post default title
[:h1 (:title site)]
contents
CLJ
  ]
 ]
; /Example

(h3 "Tag layout")
(p "Tag layout which is defined as `:tag-layout` in _config.clj has special `site` keyword.")

(ul [(p "`(:tag-name site)`: Tag name.")
     (p "`(:posts site)`: Post list which contains the tag.")])

(see-also ["Highlight Setting"
           "Clojurescript"])

; @layout  post
; @title   Edit Template
