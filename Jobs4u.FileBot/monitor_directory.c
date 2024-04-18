#include "header.h"

void monitor_directory()
{
    while (1)
    {
        /* code */

        // Inicializa as variáveis
        DIR *dir;
        struct dirent *ent;
        int current_num_files = 0;

        printf("Monitorando o diretório: %s\n", input_directory);

        if ((dir = opendir(input_directory)) != NULL)
        {
            // Se o diretório foi aberto com sucesso, lê os arquivos nele
            while ((ent = readdir(dir)) != NULL)
            {
                // Ignora os diretórios '.' e '..'
                if (strcmp(ent->d_name, ".") != 0 && strcmp(ent->d_name, "..") != 0)
                {
                    // Incrementa o contador para cada arquivo no diretório
                    current_num_files++;
                }
            }
            // Fecha o diretório após a leitura
            closedir(dir);
        }
        else
        {
            // Se o diretório não pôde ser aberto, imprime uma mensagem de erro e termina o programa
            perror("Não foi possível abrir o diretório");
            exit(EXIT_FAILURE);
        }

        // Se o número de arquivos no diretório mudou desde a última verificação
        if (current_num_files > num_files)
        {
            // Atualiza o número de arquivos
            num_files = current_num_files;
            // Envia um sinal para o processo pai
            kill(getppid(), SIGUSR1);
        }
        sleep(check_interval);
    }
}
