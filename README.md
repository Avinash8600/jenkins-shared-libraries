# Jenkins Shared Libraries

## Overview

Jenkins Shared Libraries are reusable Groovy-based modules that help standardize and simplify CI/CD pipelines by centralizing common logic across multiple Jenkins pipelines.

---

## Why Use Shared Libraries?

* Avoid code duplication
* Centralize reusable pipeline logic
* Improve maintainability
* Standardize CI/CD processes across projects

---

## Structure of Shared Library

```
(root)
├── vars/        # Global pipeline steps/functions
├── src/         # Reusable classes (Groovy code)
├── resources/   # Static files (optional)
```

---

## Key Components

* **vars/** – Contains global functions accessible in pipelines
* **src/** – Contains custom Groovy classes
* **resources/** – Stores external files like JSON, YAML, etc.

---

## Types of Libraries

* **Global Trusted Library** – Full access to Jenkins internals (configured in Manage Jenkins)
* **Global Untrusted Library** – Runs in Groovy sandbox with restricted access
* **Folder-Level Library** – Available within a specific folder
* **Local Library** – Defined and used within a single pipeline

---

## How to Configure

1. Go to **Manage Jenkins → Configure System**
2. Scroll to **Global Pipeline Libraries**
3. Add the following details:

   * **Name:** `my-shared-lib`
   * **Source:** Git repository
   * **Default Branch:** `main`

---

## Usage in Jenkins Pipeline

```groovy
@Library('my-shared-lib') _

pipeline {
    agent any

    stages {
        stage('Example') {
            steps {
                sayHello()
            }
        }
    }
}
```

---

## Example (vars/sayHello.groovy)

```groovy
def call() {
    echo "Hello from Shared Library!"
}
```

---

## Best Practices

* Keep functions small and reusable
* Use meaningful naming conventions
* Version control your library
* Add proper documentation for each function
* Use versioning (tags/branches) for stability

---

## Advantages

* Promotes code reusability
* Simplifies pipeline development
* Ensures consistency across projects
* Reduces maintenance effort

---

## Conclusion

Jenkins Shared Libraries enhance CI/CD efficiency by reducing duplication, improving maintainability, and enabling standardized pipeline development across teams.
