Where ....

*   **Local** = the local repository on each developer computer
*   **Origin** = distant "dev"repository shared between each developer

### Local

1.  Create a branch for each new _"Epic > User Story > Task"_ named as _"theNewBranchNamedWIthTaskReferenceNumber"_
2.  Commit + Commit + Commit
3.  Pull
    1.  Merge in local if necessary
    2.  Commit if a merge happened
4.  Push the branch with all the commits on "Origin"

### Origin

1.  Create a Pull Request from _"theNewBranchNamedWIthTaskReferenceNumber"_ to _"dev"_
    *   each Pull Request should be \< 300 Lignes
2.  Review another Pull Request pending Peer Review

### Pull Request Review

*   Architecture
*   Implémentation
*   Maintenability / Reusability
*   Give Positive Comments
