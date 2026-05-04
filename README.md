# Jenkins Shared Libraries

## Overview

Jenkins Shared Libraries allow you to reuse common pipeline code across multiple Jenkins pipelines. They help in maintaining clean, scalable, and DRY (Don't Repeat Yourself) CI/CD workflows.

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
├── vars/        # Global pipeline variables (Groovy scripts)
├── src/         # Reusable classes (Groovy code)
├── resources/   # Static files (optional)
```

---

## Types of Libraries

* **Global Library** – Available to all Jenkins pipelines
* **Folder-Level Library** – Available within a specific folder
* **Local Library** – Defined inside a pipeline

---

## How to Configure

1. Go to **Manage Jenkins → Configure System**
2. Scroll to **Global Pipeline Libraries**
3. Add:

   * Name: `my-shared-lib`
   * Source: Git repository
   * Default branch: `main`

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
* Add documentation for each reusable function

---

## Conclusion

Jenkins Shared Libraries improve pipeline efficiency, reduce duplication, and enable better CI/CD standardization across teams.
