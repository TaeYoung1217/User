package mission.User;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

//TODO: 구현이 될 된 클라이언트 클래스 정의
class Client {

    public static void main(String[] args) {

        // 1. 유저 정보 입력 받습니다.
        Scanner reader = new Scanner(System.in);
        System.out.print("유저명을 입력하세요: ");
        String username = reader.next();
        System.out.print("권한을 입력하세요 (admin 또는 user): ");
        String role = reader.next();
        // 2. 서버에 연결
        try (Socket socket = new Socket("localhost", 1234)) { // 서버연결
            System.out.println("서버에 연결되었습니다.");

            // TODO: 서버로 데이터를 보내기 위한 ObjectOutputStream 생성
            OutputStream outputStream = socket.getOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

            // TODO: 서버로부터 데이터를 받기 위한 InputStream 생성
            InputStream inputStream = socket.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            // TODO: UserDTO 생성 및 전송
            UserDTO userDTO = new UserDTO(username, role);
            objectOutputStream.writeObject(userDTO);
            objectOutputStream.flush();

            // TODO 서버에 메시지 전송

            // TODO: 서버로부터 받은 응답 출력
            String response = bufferedReader.readLine();

            System.out.println("서버의 응답: " + response);
            System.out.println(bufferedReader.readLine());
            System.out.println("Client가 종료되었습니다.");
            objectOutputStream.close();
            bufferedReader.close();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}