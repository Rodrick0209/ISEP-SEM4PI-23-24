#!/bin/bash

# Deployment script

# Define variables
REMOTE_USER="username"          # SSH username for the remote server
REMOTE_HOST="example.com"       # Remote server hostname or IP address
REMOTE_DIR="/path/to/app"       # Remote directory where the application will be deployed
LOCAL_DIR="/path/to/local/app"  # Local directory of the application source code

# Perform deployment steps
echo "Deploying application to $REMOTE_HOST..."

# Step 1: Navigate to the local application directory
cd "$LOCAL_DIR" || exit

# Step 2: Pull the latest changes from the repository
echo "Pulling latest changes from the repository..."
git pull origin master

# Step 3: Copy the updated files to the remote server using SCP
echo "Copying files to remote server..."
scp -r . "$REMOTE_USER"@"$REMOTE_HOST":"$REMOTE_DIR"

# Step 4: SSH into the remote server and perform additional steps if needed
echo "Connecting to remote server..."
ssh "$REMOTE_USER"@"$REMOTE_HOST" << EOF
    echo "Connected to remote server."

    # Step 5: Navigate to the deployment directory
    cd "$REMOTE_DIR" || exit

    # Step 6: Install dependencies (if needed)
    # echo "Installing dependencies..."
    # npm install

    # Step 7: Build the application (if needed)
    # echo "Building the application..."
    # npm run build

    # Step 8: Restart the application server (if needed)
    # echo "Restarting the application server..."
    # pm2 restart myapp

    # Step 9: Exit the SSH session
    echo "Deployment completed."
EOF

echo "Deployment script executed successfully."
