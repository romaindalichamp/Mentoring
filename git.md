- [Main Road Map](#main-road-map)
  * [1\. Local](#1--local)
  * [2\. Origin/dev](#2--origin-dev)
- [Create Pull Request](#create-pull-request)
- [Pull Request Peer Review](#pull-request-peer-review)
- [IntellijShortcuts](#intellijshortcuts)

<table><tbody><tr><td>Cheat Sheet</td><td>https://github.github.com/training-kit/downloads/github-git-cheat-sheet.pdf</td></tr><tr><td>Practice</td><td>https://learngitbranching.js.org/?locale=fr_FR</td></tr><tr><td>Branching</td><td>https://nvie.com/posts/a-successful-git-branching-model/</td></tr></tbody></table>

# Main Road Map

*   **Local** = the local repository on each developer computer
*   **Origin/dev** = distant "dev" repository shared between each developer

## 1\. Local

*   Create a branch for each new _**"Epic > User Story > Task"**_ named as _"**theNewBranchNamedWIthTaskReferenceNumber**"_

```
git checkout -b theNewBranchNamedWIthTaskReferenceNumber
```

*   **Commit** + Commit + Commit _...._

```
git commit -m "this message to explain my commit"
```

*   **Pull** _from_
    1.  **Merge** in local if necessary
    2.  Commit if a merge happened

```
git pull origin theNewBranchNamedWIthTaskReferenceNumber
```

*   **Push** the branch with all the commits on "Origin"

```
git push origin theNewBranchNamedWIthTaskReferenceNumber
```

## 2\. Origin/dev

*   Assuming we are currently working on "**theNewBranchNamedWIthTaskReferenceNumber**", if not:

```
git checkout theNewBranchNamedWIthTaskReferenceNumber
```

*   Update the current local branch with the shared branch "dev" and last modifications. Do **merge** if needed

```
git pull origin dev
```

*   Push updated modifications on branch "theNewBranchNamedWIthTaskReferenceNumber"

```
git push origin theNewBranchNamedWIthTaskReferenceNumber
```

# Create Pull Request

On the choosen devops software, for now GitHub [https://docs.github.com/en/github/collaborating-with-issues-and-pull-requests/creating-a-pull-request](https://docs.github.com/en/github/collaborating-with-issues-and-pull-requests/creating-a-pull-request)

*   Create a **Pull Request** from _"theNewBranchNamedWIthTaskReferenceNumber"_ to _"dev"_
    *   each Pull Request should be \< 300 lines
*   then, review another Pull Request pending validation !

# Pull Request Peer Review

*   Architecture
*   Implémentation
*   Maintenability / Reusability
*   Give Positive Comments

# IntellijShortcuts

<table><tbody><tr><td>Commit on local</td><td>CTRL + K</td></tr><tr><td>Pull from Origin / Current Branch</td><td>CTRL + T</td></tr><tr><td>Push</td><td>CTRL &nbsp;+ Shift + T</td></tr></tbody></table>
