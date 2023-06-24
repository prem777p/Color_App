
## Android Color List Application

This is an Android application developed in Java that allows users to manage and display a list of colors. The application follows the MVVM (Model-View-ViewModel) architecture pattern and utilizes a cloud database (Firebase Database or Google Sheets) for data storage. Additionally, the application supports offline functionality by storing data locally using RoomDB.


## Screenshots

![color app](https://github.com/prem777p/Color_App/assets/113753020/18cccc08-db3b-403b-87cb-83fd973bcd01)

## Features

* Color List Screen: The application includes a screen that displays a list of colors. The UI design for this screen can be found here.

* MVVM Architecture: The application follows the MVVM architecture pattern, separating the concerns of data management, UI display, and user interactions.

* Cloud Database: The application integrates with a cloud database service such as Firebase Database or Google Sheets. This allows the colors data to be stored and synchronized across multiple devices.

* Offline Mode: The color list is accessible even without an internet connection. The application utilizes RoomDB, a local database, to store the data locally. This ensures that users can view and interact with the colors list offline.

* Add Color Functionality: Users can generate a new random color by clicking the "Add Color" button. The generated color, along with the timestamp, will be stored in the local RoomDB.

* Sync Functionality: The application provides a "Sync" button that sends the locally stored color entries to the cloud server from the RoomDB. This ensures that any changes made offline are synchronized with the cloud database.

* Pending Entries Count: The sync icon displays the number of pending color entries that have not been sent to the server yet. This count updates dynamically each time data is sent to the server.

## Dependencies

1 The application utilizes the following dependencies:

2 RoomDB: A local database for storing and retrieving color data offline.

3 Cloud Database SDK: The SDK of the chosen cloud database service (Firebase or Google Sheets) for data synchronization.

4 Other necessary Android dependencies for UI components and networking.

