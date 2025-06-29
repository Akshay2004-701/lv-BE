# API Documentation

## Table of Contents
- [Users](#users)
  - [Get All Users](#get-all-users)
  - [Get User by ID](#get-user-by-id)
  - [Create User](#create-user)
  - [Update User](#update-user)
- [Datasets](#datasets)
  - [Get All Datasets](#get-all-datasets)
  - [Get Dataset by ID](#get-dataset-by-id)
  - [Create Dataset](#create-dataset)
  - [Update Dataset](#update-dataset)
- [Contributions](#contributions)
  - [Get All Contributions](#get-all-contributions)
  - [Get Contribution by ID](#get-contribution-by-id)
  - [Create Contribution](#create-contribution)
  - [Update Contribution](#update-contribution)
- [Verification Logs](#verification-logs)
  - [Get All Verification Logs](#get-all-verification-logs)
  - [Get Verification Log by ID](#get-verification-log-by-id)
  - [Create Verification Log](#create-verification-log)
  - [Update Verification Log](#update-verification-log)
- [Rewards](#rewards)
  - [Get All Reward Transactions](#get-all-reward-transactions)
  - [Get Reward Transaction by ID](#get-reward-transaction-by-id)
  - [Create Reward Transaction](#create-reward-transaction)
  - [Update Reward Transaction](#update-reward-transaction)

## Data Models

### User
```typescript
{
  id: string;                    // Auto-generated UUID
  walletAddress: string;         // User's wallet address
  username?: string;             // Optional username
  joinedAt: string;              // ISO timestamp (auto-generated)
  totalScore: number;            // Auto-calculated
  totalContributions: number;    // Auto-calculated
  tokenBalance: number;          // Auto-calculated
}
```

### Dataset
```typescript
{
  id: string;                    // Auto-generated UUID

  name: string;                  // Name of the dataset
  description: string;           // Description of the dataset
  dataType: 'TEXT' | 'IMAGE' | 'AUDIO' | 'VIDEO';
  formatRequirements: string;    // Format requirements for contributions
  sampleCountGoal: number;       // Target number of samples
  baseRewardPerSample: number;   // Base reward per contribution
  createdAt: string;             // ISO timestamp (auto-generated)
  status: 'ACTIVE' | 'CLOSED' | 'COMPLETED'  // Default: 'ACTIVE'
}
```

### Contribution
```typescript
{
  id: string;                    // Auto-generated UUID
  userId: string;                // ID of the contributing user
  datasetId: string;             // ID of the target dataset
  url?: string;                  // Optional URL to the contribution
  uploadedAt: string;            // ISO timestamp (auto-generated)
  verificationScore?: number;     // Assigned during verification
  status: 'PENDING' | 'VERIFIED' | 'REJECTED'  // Default: 'PENDING'
}
```

### Verification Log
```typescript
{
  id: string;                    // Auto-generated UUID
  contributionId: string;        // ID of the verified contribution
  modelUsed: string;             // Identifier for verification model
  score: number;                 // Verification score (0.0 - 1.0)
  reason: string;                // Explanation of verification
  verifiedAt: string;            // ISO timestamp
}
```

### Reward Transaction
```typescript
{
  id: string;                    // Auto-generated UUID
  userId: string;                // ID of the rewarded user
  contributionId: string;        // ID of the contribution being rewarded
  tokensAwarded: number;         // Amount of tokens awarded
  timestamp: string;             // ISO timestamp
  txHash: string;                // Blockchain transaction hash
}
```

## API Endpoints

## Users

### Get All Users
- **Endpoint**: `GET /api/users`
- **Description**: Retrieves all users.
- **Response**: List of User objects

### Get User by ID
- **Endpoint**: `GET /api/users/{id}`
- **Description**: Retrieves a specific user by ID.
- **Path Parameters**:
  - `id` (string, required): The ID of the user
- **Response**: User object

### Create User
- **Endpoint**: `POST /api/users`
- **Description**: Creates a new user.
- **Request Body**: User object
- **Response**: Created User object

### Update User
- **Endpoint**: `PUT /api/users/{id}`
- **Description**: Updates an existing user.
- **Path Parameters**:
  - `id` (string, required): The ID of the user to update
- **Request Body**: Updated User object
- **Response**: Updated User object


## Datasets

### Get All Datasets
- **Endpoint**: `GET /api/datasets`
- **Description**: Retrieves all datasets.
- **Response**: List of Dataset objects

### Get Dataset by ID
- **Endpoint**: `GET /api/datasets/{id}`
- **Description**: Retrieves a specific dataset by ID.
- **Path Parameters**:
  - `id` (string, required): The ID of the dataset
- **Response**: Dataset object

### Create Dataset
- **Endpoint**: `POST /api/datasets`
- **Description**: Creates a new dataset.
- **Request Body**: Dataset object
- **Response**: Created Dataset object

### Update Dataset
- **Endpoint**: `PUT /api/datasets/{id}`
- **Description**: Updates an existing dataset.
- **Path Parameters**:
  - `id` (string, required): The ID of the dataset to update
- **Request Body**: Updated Dataset object
- **Response**: Updated Dataset object


## Contributions

### Get All Contributions
- **Endpoint**: `GET /api/contributions`
- **Description**: Retrieves all contributions.
- **Response**: List of Contribution objects

### Get Contribution by ID
- **Endpoint**: `GET /api/contributions/{id}`
- **Description**: Retrieves a specific contribution by ID.
- **Path Parameters**:
  - `id` (string, required): The ID of the contribution
- **Response**: Contribution object

### Create Contribution
- **Endpoint**: `POST /api/contributions`
- **Description**: Creates a new contribution with a file.
- **Request Parameters**:
  - `file` (file, required): The file being contributed
  - `userId` (string, required): The ID of the user making the contribution
  - `datasetId` (string, required): The ID of the dataset being contributed to
- **Response**: Created Contribution object

### Update Contribution
- **Endpoint**: `PUT /api/contributions/{id}`
- **Description**: Updates an existing contribution.
- **Path Parameters**:
  - `id` (string, required): The ID of the contribution to update
- **Request Body**: Updated Contribution object
- **Response**: Updated Contribution object


## Verification Logs

### Get All Verification Logs
- **Endpoint**: `GET /api/verification-logs`
- **Description**: Retrieves all verification logs.
- **Response**: List of VerificationLog objects

### Get Verification Log by ID
- **Endpoint**: `GET /api/verification-logs/{id}`
- **Description**: Retrieves a specific verification log by ID.
- **Path Parameters**:
  - `id` (string, required): The ID of the verification log
- **Response**: VerificationLog object

### Create Verification Log
- **Endpoint**: `POST /api/verification-logs`
- **Description**: Creates a new verification log.
- **Request Body**: VerificationLog object
- **Response**: Created VerificationLog object

### Update Verification Log
- **Endpoint**: `PUT /api/verification-logs/{id}`
- **Description**: Updates an existing verification log.
- **Path Parameters**:
  - `id` (string, required): The ID of the verification log to update
- **Request Body**: Updated VerificationLog object
- **Response**: Updated VerificationLog object


## Rewards

### Get All Reward Transactions
- **Endpoint**: `GET /api/rewards`
- **Description**: Retrieves all reward transactions.
- **Response**: List of RewardTxn objects

### Get Reward Transaction by ID
- **Endpoint**: `GET /api/rewards/{id}`
- **Description**: Retrieves a specific reward transaction by ID.
- **Path Parameters**:
  - `id` (string, required): The ID of the reward transaction
- **Response**: RewardTxn object

### Create Reward Transaction
- **Endpoint**: `POST /api/rewards`
- **Description**: Creates a new reward transaction.
- **Request Body**: RewardTxn object
- **Response**: Created RewardTxn object

### Update Reward Transaction
- **Endpoint**: `PUT /api/rewards/{id}`
- **Description**: Updates an existing reward transaction.
- **Path Parameters**:
  - `id` (string, required): The ID of the reward transaction to update
- **Request Body**: Updated RewardTxn object
- **Response**: Updated RewardTxn object


